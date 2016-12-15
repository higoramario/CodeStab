package br.usp.each.saeg.code.stab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommitDiff {
	
	private Date oldDate;
	private Date newDate;
	private String oldSHA;
	private String newSHA;
	private List<String> changedFilesWithoutTests;
	private List<String> changedFilesWithTests;
	
	public CommitDiff(){
		changedFilesWithoutTests = new ArrayList<String>();
		changedFilesWithTests = new ArrayList<String>();
	}
	
	public Date getOldDate() {
		return oldDate;
	}
	public void setOldDate(Date oldDate) {
		this.oldDate = oldDate;
	}
	public Date getNewDate() {
		return newDate;
	}
	public void setNewDate(Date newDate) {
		this.newDate = newDate;
	}
	public String getOldSHA() {
		return oldSHA;
	}
	public void setOldSHA(String oldSHA) {
		this.oldSHA = oldSHA;
	}
	public String getNewSHA() {
		return newSHA;
	}
	public void setNewSHA(String newSHA) {
		this.newSHA = newSHA;
	}
	public List<String> getChangedFilesWithoutTests() {
		return changedFilesWithoutTests;
	}
	public void setChangedFilesWithoutTests(List<String> changedFiles) {
		this.changedFilesWithoutTests = changedFiles;
	}
	public int getNumberOfChangedFiles(String file){
		return this.changedFilesWithoutTests.size();
	}
	public List<String> getChangedFilesWithTests() {
		return changedFilesWithTests;
	}
	public void setChangedFilesWithTests(List<String> changedFilesWithTests) {
		this.changedFilesWithTests = changedFilesWithTests;
	}
	public int getNumberOfChangedFilesWithTests(String file){
		return this.changedFilesWithTests.size();
	}
		
}
