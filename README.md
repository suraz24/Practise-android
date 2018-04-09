# Practise-android

This is a repo used as a playground to try out the different frameworks, unit tests frameworks, IDEs, libraries and languages. It is also used to develop the best practices that will be used in the final year project. So, please make sure you follow the best practices listed below.

Also make sure you create your own master branch and work on your own branches. For eg. {Your name}/master and {Your name}/develop



# Git Flow
The git flow to be followed is:

1.	git fetch / pull 

       This is to ensures that a latest copy of the codebase is obtained which would contain any recent changes in the remote branch.          This avoids any merge conflict that may arise later.

2.	git checkout -b {branchname}
       
       Always make sure to create a new branch before you start coding. All your work should be in a different branch. This is to ensure        that if something goes wrong, bugs are contained in one branch.

3.	git status

      After working on a branch, this command can be used to list all the files that have been added, modified or removed. It helps to         decide what files need to be added to commit. The use of `git diff <filename>` is encouraged to check the changes in the file if         there is a confusion regarding changes in the file.


4.	git add {filename}
       
      This is to add the files that needs to be committed. If all the changes displayed in the status needs to be added, `git add .`              could be used instead.

5.	git commit -m {message}
       
       A proper commit message should be added for each commit. It should explain what was changed and what has been solved as a result.

6.	git push

       This pushes the code to the remote server in the cloud. Until this step, everything was in the local machine.

7.	Create a pull request on github:

       A pull request to merge the code needs to be create after completing a task. To ensure the quality, there needs to be a minimum          of 2 reviewers and only the dev lead should merge the codes.

# Best Practices

1.	Always pull from either develop or the branch you are in before you start coding.
2.	Always create a new branch when you are working on a feature. One branch should only contain codes related to one feature.
3.	Always branch out from develop to ensure that you get the latest copy of another members work. This reduces merge conflict              significantly.
4.	Always create a pull request to merge back to develop once you have completed development and add other members for code review.
5.	Use git diff or git add -p to make sure you are not pushing anything unnecessary
6.	Keep the branch names and commit message meaningful. krishna_branch might not provide a lot of information about the branch is           but feature/hand-gesture-swipe-right does.
7.	Commit more often and small section of codes. Only one issue needs to be addressed in one commit.
8.	Never push anything to develop or master or somebody else’s branch unless the need.
9.	Do not work on multiple branches/feature at once. This will create merge conflict.
10.	If there is a merge_conflict, try to solve it locally. If unsure, do not push it to the cloud.
11.	While reviewing, check the code difference in the github, pull the repo locally and run the code and verify everything is working        as intended. Check if any unit test are failing if everything is all good, then only approve the pull request. 
12.	A pull request can be merged only if all reviewer have approved and any pull request must have atleast 2 reviewer.
