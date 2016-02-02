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
	@./update_results.sh
	@./update.sh
