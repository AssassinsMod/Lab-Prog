t=all

all:
	@echo "Nothing to see here :D"

test:
ifeq ($(t), all)
	@./gradlew test
else
	@./gradlew "$(shell echo $(t) | sed 's/\/\(.\)/:\1/g' | sed 's/\///g')":test
endif

docs:
ifeq ($(t), all)
	@./gradlew javadoc
else
	@./gradlew "$(shell echo $(t) | sed 's/\/\(.\)/:\1/g' | sed 's/\///g')":javadoc
endif

html:
	@./results.sh

update:
	@./update_results.sh
	@./update.sh
