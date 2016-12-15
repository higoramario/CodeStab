# CodeStab
CodeStab check for changes in commits of Java projects

1. After choose a project, clone it and create a log file -> git log --pretty=format:"%H - %cd - %s" > ../git-log-project_name
2. Choose commits of your interest and add them in the CommitLoader class in descending order of date -> public static List<String> project_nameCommits(){
3. Check the project to identify patterns of test classes you want to ignore and include these patterns in the CommitLoader class -> public static List<String> project_nameTestPatterns(){
4. In the Process class, put your local folder that contains the git project folder in the variable filePath -> filePath = "/home/user/codestab/";
5. To run CodeStab, change the main method of the Reader class -> Process process = new Process(CommitLoader.project_nameCommits(),"project_name",CommitLoader.project_nameTestPatterns());

The CodeStab's outcome are files that indicate:
- Java files changed between a commit and its previous one*
- Java files changed between a commit and the latest one*
- amount of Java files changed through the commits
- ranking of the number of changes for each Java file between the oldest and the latest commit
- Java files and test files changed between a commit and its previous one*
- Java files and test files changed between a commit and the latest one*

-* considering commits included in the CommitLoader class
