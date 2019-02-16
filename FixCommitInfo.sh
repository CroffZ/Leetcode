git filter-branch --env-filter '

OLD_NAME="钟坤甫"
OLD_EMAIL="zhongkunfu@bytedance.com"
NEW_NAME="CroffZ"
NEW_EMAIL="324716891@qq.com"

if [ "$GIT_COMMITTER_NAME" = "$OLD_NAME" ]
then
    export GIT_COMMITTER_NAME="$NEW_NAME"
fi

if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_COMMITTER_EMAIL="$NEW_EMAIL"
fi

if [ "$GIT_AUTHOR_NAME" = "$OLD_NAME" ]
then
    export GIT_AUTHOR_NAME="$NEW_NAME"
fi

if [ "$GIT_AUTHOR_EMAIL" = "OLD_EMAIL" ]
then
    export GIT_AUTHOR_EMAIL="$NEW_EMAIL"
fi

' --tag-name-filter cat -- --branches --tags
