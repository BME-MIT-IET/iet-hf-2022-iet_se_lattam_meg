A projekthez nem tartozott semmilyen build keretrendszer, mivel ez egy függvénykönyvtár volt. Az általunk készített Main.java osztály köti össze ezeket a különálló fájlokat, és ezzel kapott a projekt egy parancssori felületet is.

Készült egy maven.yml a GitHub Actions-t vezérli. Ezzel lefutnak az automatikus tesztek is minden, a Main branch-en történő commit illetve erre történő pull request esetében.

Ezen kívül van egy pom.xml fájlunk, amibe a dependency-k kerültek, mint a JUnit, Cucumber, JaCoCo, stb.

Eredmény: sikeresen összeraktunk egy CI pipeline-t a GitHub Actions-el, ami automatikusan lefuttatja a teszteket minden commit és pull request esetében

Tanulság: az automatikus tesztelés a main-en történő változások esetében kifejezetten hasznos volt, ugyanis ezzel biztosak lehettünk abban, hogy ami változtatás oda felkerül, az jól működik és nem rontja el a már működő kódunkat. Ennek segítségével sikerült például a java package-elésével kapcsolatos hibát találnunk, amit enélkül valószínűleg sokkal tovább tartott volna észrevennünk