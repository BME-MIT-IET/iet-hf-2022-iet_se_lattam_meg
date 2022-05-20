A projekthez nem tartoztak tesztesetek, mivel ez egy függvénykönyvtár volt.

Unit teszteket készítettünk a BubbleSort, MergeSort és HeapSort osztályokhoz a rendezéshez, belső működésükkel kapcsolatban. Törekedtünk a különböző edge case-k tesztelésére pl. üres tömb rendezése.

Eredmény: A tesztelt osztályok jól működnek, refaktorálásuk esetén támaszkodhatunk a tesztesetekre az helyesség ellenőrzése során.

Tanulság: Az osztályoknak különböző interfészük volt, ami megnehezíti a használatukat, és a tesztelésüket is. Egyes algoritmusoknál bizonyos bonyolultabb műveletekre privát függvények voltak használva, amiket így ugye nem tesztelünk, megfontolandó ezen nagyobb komplexitású kódrészek kiemelése (pl. belső osztály), hogy külön tesztelhetőek legyenek. Emellett megfigyelhető, hogy ezen matematikai algoritmusokat rendesen tesztelni a kód elolvasásával lehet csak, illetve talán célszerűbb lenne helyességüket matematikai alapon / formális módszerekkel bizonyítani.