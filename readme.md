## Groovy Koans Project ##

The Groovy Koans project is a collection of small exercises in the form of unit tests, designed to get Java
developers up to speed on Groovy features and common idioms. It starts by teaching you basic Groovy building
blocks, and gradually builds your knowledge towards metaprogramming, slurpers, and all the goodness Groovy has
to offer.

## Getting Started ##
1.  Make sure you have [JDK 1.6+][jdk] installed 
2.  Download and unzip the [Koans][zip] (or clone the GitHub repository with `$ git clone https://github.com/nadavc/groovykoans.git`)
3.  Remove the solutions from the Koans using `$ ./gradlew removeSolutions`
4.  Execute Koan01 with `$ ./gradlew koan01` and fail (or any other Koan using `$ ./gradlew koan##`)
5.  Fix code, and execute again
6.  Keep going until you're fluent at Groovy :)

## Q&A ##

#### I like IntelliJ. How can I use it to debug/edit the Koans? ####

* Download and install [IntelliJ IDEA Community Edition][ideac]
* Run `./gradlew idea` from the root of your unzipped Koans
* In IDEA, `File -> Open Project` and open the generated `ipr` file

#### I am forced to work behind a proxy. Can I still run the Koans? ####

The `gradlew` script downloads Groovy and Gradle for you, so you don't have to set up anything by yourself.
To allow gradlew to work through your proxy, simply add the following parameters:
```
$ ./gradlew koan01 -Dhttp.proxyHost=[http proxy] -Dhttp.proxyPort=[http proxy port]
```

#### The answers are already there! What's the point?  ####

One of the perks of learning through Koans is that once your Koan is solved, you can compare your solution with
the 'official' solution and perhaps learn from that comparison as well. It is also a way to make sure that the Koans
are indeed solvable by filling in the blanks.

For optimal learning experience, however, you should first try to solve the Koans without those solutions as reference.
To remove the solutions, run `$ ./gradlew removeSolutions` from the root of your unzipped Koans.

#### Are there more Koans planned? How will I know? ####

These are the Koans that are currently planned: 
* Testing
* Spock framework
* Embedding Groovy
* Creating your own DSL
* Creating your own builder

Follow me on [Twitter][twitter] or [GitHub][github] for updates.

## Credits and License ##
The Koan concept started way back in [Zen][zen] practice. It was then adapted by the good folks of
[rubykoans.com][rubykoans] and perfected by [Neo4j][neo4j]. The Groovy Koans project is licensed under the
[Apache 2 License][apache2].


Please feel free to leave comments and pull requests :)

Enjoy!

[jdk]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[zip]: https://github.com/nadavc/groovykoans/archive/master.zip
[ideac]: http://www.jetbrains.com/idea/download/
[twitter]: http://twitter.com/nadavc
[github]: http://github.com/nadavc
[zen]: http://en.wikipedia.org/wiki/K%C5%8Dan
[rubykoans]: http://rubykoans.org
[neo4j]: https://github.com/jimwebber/neo4j-tutorial
[apache2]: http://www.apache.org/licenses/LICENSE-2.0.html
