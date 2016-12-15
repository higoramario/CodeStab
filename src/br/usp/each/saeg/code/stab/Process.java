package br.usp.each.saeg.code.stab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jgit.api.Git;

import br.usp.each.saeg.code.stab.utils.MapUtil;

public class Process {
	
	//project info
	String filePath = "/home/higor/data/code-stability-test";
	String repoPath = "";
	File repoDir;
	String projectName = "";
	Reader reader;
	
	String firstCommit;
	String lastCommit;
	List<CommitDiff> listCommitDiffs = new ArrayList<CommitDiff>();//from month to month sequentially, used to save the files with the name of the changed files
	List<CommitDiff> listCommitDiffsFromNewest = new ArrayList<CommitDiff>();//from the newest month to all other months
	Map<String,Integer> rankingOfChangedFiles = new LinkedHashMap<String,Integer>();//all files changed between the commits and the number of changes
	Map<String,String> listOfComparedCommits = new LinkedHashMap<String,String>();
	Map<Integer,Integer> numberOfChangedFiles = new LinkedHashMap<Integer,Integer>();//sums the total of changed files per number of changes in each file
	List<String> listOfCommits = new ArrayList<String>();
	
	public Process(List<String> commits, String project, List<String> testPatterns){
		listOfCommits = commits;
		projectName = project;
		repoPath = filePath+"/"+projectName;
		repoDir = new File(repoPath);
		reader = new Reader(repoDir,testPatterns);
	}
	
	//from the most recent to the old one
	public void filloutCommits(){
		//listOfComparedCommits.put("3fa138", "6957e4");
		//listOfComparedCommits.put("22a9a6b0d412f31ea0f15ac389e56b9de9eeadb1", "5b4a708704b7f6172f087d6cfe43114dfab57f53");
		for(int i = 1; i < listOfCommits.size(); i++){
			listOfComparedCommits.put(listOfCommits.get(i-1),listOfCommits.get(i));
		}
	}
	
	public void process(){
		filloutCommits();
		
		Set<String> commitSet = listOfComparedCommits.keySet();
		for(String sha : commitSet){
			CommitDiff commitDiff = reader.getFilesChangedBetweenCommits(sha,listOfComparedCommits.get(sha));
			listCommitDiffs.add(commitDiff);
		}
		//get diffs between the newest to all other previous commits
		String newestSHA = listOfCommits.get(0);
		for(int i = 1; i < listOfCommits.size(); i++){
			CommitDiff commitDiff = reader.getFilesChangedBetweenCommits(newestSHA,listOfCommits.get(i));
			listCommitDiffsFromNewest.add(commitDiff);
		}
		for(CommitDiff commitDiff : listCommitDiffs){
			saveChangedFiles(commitDiff, "");
		}
		for(CommitDiff commitDiff : listCommitDiffsFromNewest){
			saveChangedFiles(commitDiff, "from-newest-");
		}
		saveNumberOfChangedFilesPerCommit(listOfCommits.get(0), listOfCommits.get(listOfCommits.size()-1));
		
		filesChangedFilesBetweenCommits(listOfCommits.get(0), listOfCommits.get(listOfCommits.size()-1));
		sumChangedFilesPerNumberOfChangesInEachFile();
		saveRankingOfChangedFiles();
	}
	
	//receives the newest and the oldest commits
	public void filesChangedFilesBetweenCommits(String SHANewest, String SHAOldest){
		CommitDiff commitDiff = reader.getFilesChangedBetweenCommits(SHANewest,SHAOldest);
		List<String> allFiles = commitDiff.getChangedFilesWithoutTests();
		for(String file : allFiles){
			int numberOfChanges = reader.countNumberOfChangesInFileBetweenCommits(SHANewest, SHAOldest, file);
			rankingOfChangedFiles.put(file, numberOfChanges);
		}
		rankingOfChangedFiles = MapUtil.sortByValue(rankingOfChangedFiles);
	}
	
	private void sumChangedFilesPerNumberOfChangesInEachFile() {
		Set<String> changedFiles = rankingOfChangedFiles.keySet();
		for(String file : changedFiles){
			int numberOfChanges = rankingOfChangedFiles.get(file);
			if(!numberOfChangedFiles.containsKey(numberOfChanges)){
				numberOfChangedFiles.put(numberOfChanges,1);
			}else{
				int previousNumber = numberOfChangedFiles.remove(numberOfChanges);
				numberOfChangedFiles.put(numberOfChanges,previousNumber+1);
			}
		}
	}

	
	public void saveChangedFiles(CommitDiff commitDiff, String type){
		String fileNameWithoutTests;
		String fileNameWithTests;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		fileNameWithoutTests = projectName + "-" + type +  
					dateFormat.format(commitDiff.getNewDate()) + "-" + 
					dateFormat.format(commitDiff.getOldDate());
		fileNameWithTests = projectName + "-tests-" + type + 
				dateFormat.format(commitDiff.getNewDate()) + "-" + 
				dateFormat.format(commitDiff.getOldDate());

		try {
			FileWriter fileWriter = new FileWriter(filePath+"/"+fileNameWithoutTests);
			for(String line : commitDiff.getChangedFilesWithoutTests()){
				fileWriter.write(line);
				fileWriter.write(System.lineSeparator());
			}
			fileWriter.close();
			
			fileWriter = new FileWriter(filePath+"/"+fileNameWithTests);
			for(String line : commitDiff.getChangedFilesWithTests()){
				fileWriter.write(line);
				fileWriter.write(System.lineSeparator());
			}
			fileWriter.close();
			//System.out.println("That's all!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveRankingOfChangedFiles(){
		String fileName = projectName + "-rankingOfChangedFiles";
		try {
			FileWriter fileWriter = new FileWriter(filePath+"/"+fileName);
			Set<String> changedFiles = rankingOfChangedFiles.keySet();
			fileWriter.write("========== Ranking of changed files ===========");
			fileWriter.write(System.lineSeparator());
			for(String file : changedFiles){
				fileWriter.write(rankingOfChangedFiles.get(file)+ " : " +file);
				fileWriter.write(System.lineSeparator());
				//System.out.println(listOfChangedFiles.get(file)+ " : " +file);
			}
		
			fileWriter.write("========== SUMMARY ===========");
			fileWriter.write(System.lineSeparator());
		
			Set<Integer> numberOfChanges = numberOfChangedFiles.keySet();
			for(Integer number : numberOfChanges){
				fileWriter.write(number+ " : " +numberOfChangedFiles.get(number));
				fileWriter.write(System.lineSeparator());
			}
			fileWriter.close();
			System.out.println("Ranking of changed files saved.");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveNumberOfChangedFilesPerCommit(String SHANewest, String SHAOldest){
		String fileName = projectName + "-numberOfChangedFilesPerCommit";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			FileWriter fileWriter = new FileWriter(filePath+"/"+fileName);
			fileWriter.write("========== Number of changed java files per commit (without test files) ===========");
			fileWriter.write(System.lineSeparator());
			for(CommitDiff commitDiff : listCommitDiffs){
				fileWriter.write(dateFormat.format(commitDiff.getNewDate()) + "-" + dateFormat.format(commitDiff.getOldDate()) + " : " + commitDiff.getChangedFilesWithoutTests().size());
				fileWriter.write(System.lineSeparator());
				//System.out.println(listOfChangedFiles.get(file)+ " : " +file);
			}
			fileWriter.write("Total number of commits: "+reader.countNumberOfCommitsBetweenCommits(SHANewest, SHAOldest));
			fileWriter.write(System.lineSeparator());
			fileWriter.write("========== Number of changed java files per commit (without test files) from the newest to all other commits ===========");
			fileWriter.write(System.lineSeparator());
			for(CommitDiff commitDiff : listCommitDiffsFromNewest){
				fileWriter.write(dateFormat.format(commitDiff.getNewDate()) + "-" + dateFormat.format(commitDiff.getOldDate()) + " : " + commitDiff.getChangedFilesWithoutTests().size());
				fileWriter.write(System.lineSeparator());
				//System.out.println(listOfChangedFiles.get(file)+ " : " +file);
			}
			fileWriter.write(System.lineSeparator());
			fileWriter.write("========== Total number of java files per commit (without test files) ===========");
			fileWriter.write(System.lineSeparator());
			for(String commit : listOfCommits){
				fileWriter.write(commit+" - "+dateFormat.format(reader.getCommitDate(commit))+" : "+reader.countNumberOfFilesInACommit(commit));
				fileWriter.write(System.lineSeparator());
			}
			fileWriter.close();
			System.out.println("Number of changed files per commit saved.");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
