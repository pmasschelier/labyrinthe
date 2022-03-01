JC=javac
JFLAGS=
JVM=java
MAIN=main.MainMaze
EXEC=MazeApp.jar
SRCDIR=src
CLASSDIR=class
SRC=$(shell cd $(SRCDIR) && find * -name "*.java")
CLASSES=$(subst .java,.class,$(SRC))

# $@ est le nom de la cible
# $^ est la liste des dépendances
# $< est la première dépendance

# rajouter @ devant une commande pour la rendre silencieuse


# La ligne « export CLASSPATH=. » sert à indiquer à Java qu’il doit également chercher les programmes class dans le répertoire courant. Ce chemin peut également être spécifié au lancement du programme par l’option -classpath (ou -cp en abrégé) :
# java -cp. HelloWorld

export CLASSPATH=$(SRCDIR)

all: $(EXEC)

$(CLASSDIR):
	mkdir -p $(CLASSDIR)

$(CLASSDIR)/%.class:$(SRCDIR)/%.java $(CLASSDIR)
	$(JC) -d $(CLASSDIR) $(JFLAGS) $<

$(EXEC): $(CLASSES:%=$(CLASSDIR)/%)
	@cd $(CLASSDIR); jar -cfe ../$@ $(MAIN) $(CLASSES)

.PHONY: run clean doc

run: $(EXEC)
	java -jar $<

doc:
	@cd $(SRCDIR); javadoc -d ../$@ $(SRC)

clean:
	rm -rf $(EXEC) $(CLASSDIR)
