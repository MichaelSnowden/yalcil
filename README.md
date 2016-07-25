# Get started

The easiest way to get started is to clone this repository from source, build it, and add a command line script or alias to activate the jar file.

First, build the jar file

```bash
git clone https://github.com/MichaelSnowden/yalcil.git
cd yalcil
mvn clean compile assembly:single
```

Then, add a script which runs it

```bash
cd /path/to/yalcil/src/main/resources
java -jar /path/to/yalcil/target/yalcil.jar "$@"
```

Now you can enter the REPL using

```bash
$ yalcil
> (pbtree (grow (leaf 1) 3))
                              8 
              4                               12
      2               6               10              14
  1       3       5       7       9       11      13      15
```

How did that work?

The `yalcil.jar` file packages the main method for the read eval print loop. By cd'ing into `yalcil/src/main/resources` first, you enter
the REPL with a bunch of other scripts written in this language. Those scripts include "pbtree", "grow", and "leaf". The script "leaf" 
creates a tree-like structure `(x nil nil)`. The script "grow" expands the tree `X -> ((max X) X (+ X (max X)))`. Run 
`ls /path/to/yalcil/src/main/resources` to see the available scripts. However, there are other functions built in the interpreter that 
you can see in the file `Runtime`. There is also a Javascript interpreter which you can enter by opening `website/index.html`. Because 
this is a pure language, I plan on memoizing and parallelizing it in the near future. I also want to rename it to something that isn't 
so hard to say.
