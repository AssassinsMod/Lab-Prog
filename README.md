# Laboratorio di Programmazione
Il progetto sfrutta [Gradle][] per gestire le fasi di build e test.  
In questo ambito, simulazioni ed esercizi sono considerato dei
*sottoprogetti* che condividono gli stessi *task*.

Per avere un'idea dei diversi *task* disponibili raccomando di dare
un'occhiata alla documentazione del [plugin java][] di gradle.

In ogni caso la sintassi generale è:
```
$ ./gradlew :<tipo>:<nome>:<task>

# Es: Eseguire i test della simulazione 'Autostrada'
$ ./gradlew :simulazioni:Autostrada:test
```

## Come contribuire
Per contribuire basta creare una **pull request** (come descritto in
[questa guida][gh-pull-request]) o suggerire delle modifiche aprendo
un **issue**.

[Gradle]: http://gradle.org/
[plugin java]: http://gradle.org/getting-started-gradle-java/
[gh-pull-request]: https://help.github.com/articles/using-pull-requests/



## Esami
|    Nome    |   Sorgenti    |   Risultati   |     Docs      |
|:---------- |:-------------:|:-------------:|:-------------:|
| Scuola     | [link][src-3] | [link][res-3] | [link][doc-3] |


## Esercizi


## Simulazioni
|    Nome    |   Sorgenti    |   Risultati   |     Docs      |
|:---------- |:-------------:|:-------------:|:-------------:|
| Autostrada | [link][src-1] | [link][res-1] | [link][doc-1] |
| Cassa      | [link][src-2] | [link][res-2] | [link][doc-2] |


[src-1]: /simulazioni/Autostrada/src/main/java
[src-2]: /simulazioni/Cassa/src/main/java
[src-3]: /esami/Scuola/src/main/java

[res-1]: http://assassinsmod.github.io/Lab-Prog/test/Autostrada
[res-2]: http://assassinsmod.github.io/Lab-Prog/test/Cassa
[res-3]: http://assassinsmod.github.io/Lab-Prog/test/Scuola

[doc-1]: http://assassinsmod.github.io/Lab-Prog/docs/Autostrada
[doc-2]: http://assassinsmod.github.io/Lab-Prog/docs/Cassa
[doc-3]: http://assassinsmod.github.io/Lab-Prog/docs/Scuola
