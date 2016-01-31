# Laboratorio di Programmazione
Il progetto sfrutta [Gradle][] per gestire le fasi di build e test.  
In questo ambito, simulazioni ed esercizi sono considerato dei *sottoprogetti* che condividono gli stessi *task*.

Per avere un'idea dei diversi *task* disponibili raccomando di dare un'occhiata alla documentazione del [plugin java][] di gradle.

In ogni caso la sintassi generale è:
```
$ ./gradlew :<tipo>:<nome>:<task>

# Es: Eseguire i test della simulazione 'Autostrada'
$ ./gradlew :simulazioni:Autostrada:test
```


## Esercizi


## Simulazioni
- [Autostrada][] - [risultati][ris-autostrada]
- [Cassa][] - [risultati][ris-cassa]



[Gradle]: http://gradle.org/
[plugin java]: http://gradle.org/getting-started-gradle-java/

[ris-autostrada]: http://assassinsmod.github.io/Lab-Prog/Autostrada.html
[ris-cassa]: http://assassinsmod.github.io/Lab-Prog/Cassa.html

[Autostrada]: /simulazioni/Autostrada
[Cassa]: /simulazioni/Cassa