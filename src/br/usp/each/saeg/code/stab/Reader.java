package br.usp.each.saeg.code.stab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.io.DisabledOutputStream;

public class Reader {
	
	Git git;
	String filePath;
	File repoDir;
	List<String> testPatterns;
	
	public Reader(File dir, List<String> patterns){
		repoDir = dir;
		read(this.repoDir);
		testPatterns = patterns;
	}
	
	public void read(File repoDir){
		try {
			Repository repo = new FileRepository(repoDir + "/.git");
			git = new Git(repo);
			git = Git.open(repoDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//count number of commits for a file through history
	public int countNumberOfChangesInFile(String javaFile){
		int count = 0;
		//read(this.repoDir);
		//String javaFile = "hadoop-common-project/hadoop-common/src/main/java/org/apache/hadoop/fs/FileSystem.java";
		try {
			Iterable<RevCommit> logs = git.log().addPath(javaFile).call();
			for(RevCommit rev : logs){
				count++;
			}
			//System.out.println("Commits:"+count);
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//count number of commits for a file between two commits
	public int countNumberOfChangesInFileBetweenCommits(String SHANew, String SHAOld, String javaFile){
		int count = 0;
		//String SHANew = "3fa138";
		//String SHAOld = "6957e4";
		//String javaFile = "hadoop-common-project/hadoop-common/src/main/java/org/apache/hadoop/fs/FileSystem.java";
		ObjectId oldTree;
		ObjectId newTree;
		//read(this.repoDir);
		try {
			newTree = git.getRepository().resolve(SHANew);
			oldTree = git.getRepository().resolve(SHAOld);
			Iterable<RevCommit> logs = git.log().addRange(oldTree, newTree).addPath(javaFile).call();
			
			for(RevCommit rev : logs){
				//System.out.println(rev.getAuthorIdent().getWhen());
				count++;
			}
			//System.out.println("Commits:"+count);
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}	
	
	public CommitDiff getFilesChangedBetweenCommits(String SHANew, String SHAOld){
		//read(this.repoDir);
		ObjectReader reader = git.getRepository().newObjectReader();
		CanonicalTreeParser oldTreeIter = new CanonicalTreeParser();
		CanonicalTreeParser newTreeIter = new CanonicalTreeParser();
		ObjectId oldTree;
		ObjectId newTree;
		CommitDiff commitDiff = new CommitDiff();
		try {
			oldTree = git.getRepository().resolve(SHAOld+"^{tree}");
			oldTreeIter.reset(reader, oldTree);
			newTree = git.getRepository().resolve(SHANew+"^{tree}");
			newTreeIter.reset(reader, newTree);
			
			DiffFormatter diffFormatter = new DiffFormatter(DisabledOutputStream.INSTANCE);
			diffFormatter.setRepository(git.getRepository());
			
			List<DiffEntry> entries = diffFormatter.scan(oldTree,newTree);
			
			commitDiff.setOldSHA(git.getRepository().resolve(SHAOld).getName());
			commitDiff.setNewSHA(git.getRepository().resolve(SHANew).getName());
			
			RevWalk walk = new RevWalk(git.getRepository());
			RevCommit revCom = walk.parseCommit(git.getRepository().resolve(SHANew));
			commitDiff.setNewDate(revCom.getAuthorIdent().getWhen());
			revCom = walk.parseCommit(git.getRepository().resolve(SHAOld));
			commitDiff.setOldDate(revCom.getAuthorIdent().getWhen());
			walk.close();
			
			for(DiffEntry entry : entries){
				boolean isTestFile = false; 
				if(entry.getOldPath().contains(".java")){//show files an specific text
					commitDiff.getChangedFilesWithTests().add(entry.getOldPath());
					//System.out.println(entry.getChangeType() + ": " + entry.getOldPath());// + ", id " + oldTree.name());
					//System.out.println(entry.getOldPath());
					
					for(String pattern : testPatterns){
						if(entry.getOldPath().contains(pattern)){
							isTestFile = true;
						}
					}
					
					if(!isTestFile){
						commitDiff.getChangedFilesWithoutTests().add(entry.getOldPath());
					}
				}
			}
			
			diffFormatter.close();
			
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commitDiff;
	}
	
	//count number of commits between two commits
	public int countNumberOfCommitsBetweenCommits(String SHANew, String SHAOld){
		int count = 0;
		//String SHANew = "3fa138";
		//String SHAOld = "6957e4";
		ObjectId oldTree;
		ObjectId newTree;
		//read(this.repoDir);
		try {
			newTree = git.getRepository().resolve(SHANew);
			oldTree = git.getRepository().resolve(SHAOld);
			
			Iterable<RevCommit> rangeOfLogs = git.log().addRange(oldTree, newTree).call();
			for(RevCommit rev : rangeOfLogs){
				count++;
			}
			//System.out.println("Commits:"+count);
		} catch (NoHeadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//alternative way to navigate through the commits
			/*RevWalk walk = new RevWalk(git.getRepository());
			RevCommit revCom = walk.parseCommit(object);
			walk.markStart(revCom);
			System.out.println(revCom.getFullMessage());
			
			Iterator<RevCommit> commits = walk.iterator();
			int countnew = 0;
			while(commits.hasNext()){
				RevCommit rc = commits.next();
				if(countnew<100)
					System.out.println(rc.getId());
				countnew++;
			}
			System.out.println("Commits:"+countnew);*/
		return count;	
	}
	

	public ObjectId getRefObjectId(Ref ref){
		Ref repoPeeled = git.getRepository().peel(ref);
		if(repoPeeled.getPeeledObjectId() != null){
			return repoPeeled.getPeeledObjectId();
		}
		return ref.getObjectId();
	}
	
	//return the number of java files in a commit without tests
	public int countNumberOfFilesInACommit(String sha){
		RevWalk walk;
		ObjectId id;
		RevCommit commit;
		RevTree tree;
		TreeWalk treeWalk;
		int counter = 0;
		try {
			walk = new RevWalk(git.getRepository());
			id = git.getRepository().resolve(sha);
			commit = walk.parseCommit(id);
			tree = commit.getTree();
			
			//System.out.println("Having tree: " + tree);
			
			treeWalk = new TreeWalk(git.getRepository());
			treeWalk.addTree(tree);
			treeWalk.setRecursive(true);
			
			while(treeWalk.next()){
				boolean isTestFile = false; 
				
				if(treeWalk.getPathString().endsWith(".java")){//show files an specific text
										
					for(String pattern : testPatterns){
						if(treeWalk.getPathString().contains(pattern)){
							isTestFile = true;
						}
					}
					if(!isTestFile){
						counter++;
						//System.out.println("file: "+treeWalk.getPathString());
					}
				}
			}
			//System.out.println("files: "+counter); 
			walk.close();
			treeWalk.close();
			
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}
	
	public Date getCommitDate(String sha){
		Date date = null;
		RevWalk walk;
		RevCommit revCom;
		try {
			walk = new RevWalk(git.getRepository());
			revCom = walk.parseCommit(git.getRepository().resolve(sha));
			date = revCom.getAuthorIdent().getWhen();
			walk.close();
		} catch (RevisionSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String args[]){
		BasicConfigurator.configure();
		
		//project info
		//String filePath = "/home/higor/data/code-stability-test";
		//String repoPath = filePath+"/hadoop";
		//File repoDir = new File(repoPath);
		//Reader r = new Reader(repoDir);
		//r.countNumberOfFilesInCommit("22a9a6b0d412f31ea0f15ac389e56b9de9eeadb1");
		//r.read();
		//r.countNumberOfChangesInFile();
		//r.getFilesChangedBetweenCommits();
		//r.countNumberOfCommitsBetweenCommits();
		//r.countNumberOfChangesInFileBetweenCommits();
		
		//Process process = new Process(CommitLoader.hadoopCommits(),"hadoop",CommitLoader.hadoopTestPatterns());
		//Process process = new Process(CommitLoader.guavaCommits(),"guava",CommitLoader.guavaTestPatterns());
		//Process process = new Process(CommitLoader.jenaCommits(),"jena",CommitLoader.jenaTestPatterns());
		//Process process = new Process(CommitLoader.kafkaCommits(),"kafka",CommitLoader.kafkaTestPatterns());
		//Process process = new Process(CommitLoader.elasticSearchCommits(),"elasticsearch",CommitLoader.elasticSearchTestPatterns());
		//Process process = new Process(CommitLoader.cassandraCommits(),"cassandra",CommitLoader.cassandraTestPatterns());
		//Process process = new Process(CommitLoader.groovyCommits(),"groovy",CommitLoader.groovyTestPatterns());
		//Process process = new Process(CommitLoader.jmeterCommits(),"jmeter",CommitLoader.jmeterTestPatterns());
		//Process process = new Process(CommitLoader.tomcatCommits(),"tomcat",CommitLoader.tomcatTestPatterns());
		//Process process = new Process(CommitLoader.qpidCommits(),"qpid",CommitLoader.qpidTestPatterns());
		//Process process = new Process(CommitLoader.cheCommits(),"che",CommitLoader.cheTestPatterns());
		Process process = new Process(CommitLoader.vraptor4Commits(),"vraptor4",CommitLoader.vraptor4TestPatterns());
		process.process();
		//process.filesChangedFilesBetweenCommits("3fa138", "6957e4");
		//process.saveRankingOfChangedFiles();
		
	}
		
}
