.PHONY: html

t=all

all:
	@echo "Nothing to see here :D"

test:
	@echo "Testing.."
ifeq ($(t), all)
	@./gradlew -q test
else
	@./gradlew -q "$(shell echo $(t) | sed 's/\/\(.\)/:\1/g' | sed 's/\///g')":test
endif

docs:
	@echo "Generating docs.."
ifeq ($(t), all)
	@./gradlew -q javadoc
else
	@./gradlew -q "$(shell echo $(t) | sed 's/\/\(.\)/:\1/g' | sed 's/\///g')":javadoc
endif

html:
	@./results.sh

update:
	@echo "Pushing master"
	@git checkout master
	@git push origin master --tags

	@echo "Pushing develop"
	@git checkout develop
	@git push origin develop

	@echo "Pushing gh-pages"
	@git add "html"
	@git commit -m "[AUTO] Updated html sites"
	@git subtree push --prefix "html" origin gh-pages
