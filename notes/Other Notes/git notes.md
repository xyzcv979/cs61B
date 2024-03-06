# Git notes

Git is a distirbuted version control system for easier code collaboration on projects as well as using it for reverting to previous history states

Understand the following concepts:
- Local git workflow: git add and git commit
- Moving between commits and updating files with git checkout
- Detached HEAD states
- Remote repositories, e.g. those hosted on GitHub
- Local git integration with remote repositories: origin/master and skeleton/master
- How to resolve merge conflicts

Git Commands:
- git init
- git clone
- git log
- git checkout
- git add
- git commit
- git push

First you add changes to the staging area, then this is commited and then pushed to master on the branch\
`MASTER` vs `HEAD`. Master is always the pointer to the latest commit. Head is your current location, typically at Master. If you checkout an older commit, your Head points to that commit and becomes `DETACHED HEAD`. Just checkout master to get back to most recent commit

`origin/master` is the master commit of the origin repo. Any updates in origin repo will require a `git pull` before you can push changes.

Git conflicts. When pulling a merge conflict, need to resolve the lines of code

Skeleton repo. Like a repo with templates. You checkout the skeleton repo, push changes to your own repo (more commits), when skeleton repo is updated and you pull changes from it, the new commit is added and your new pointer points to it. There is a `skeleton/master` pointer which is the commit relate to skeleton repo

To grab a specific file/folder from past commit by itself, you can do `git checkout <commit id> --<file/folder name>`. It will add the file/folder to your current head.


