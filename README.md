# latexbreak

## configuration

The working directory must contain a configuration file called latexbreak.config.
[Here](https://github.com/ffrohn/latexbreak/blob/master/latexbreak.config) you can find an example for such a configuration file.
Lines starting with `#` are comments.

- `remove_newlines [true|false]`: If set to true, then existing linebreaks will be removed from the document. Otherwise, existing linebreaks remain unchanged.
- `break_after_sentences [true|false]`: automatically break lines after sentences
- `line_ends`: comma-separated list of characters that indicate the end of a sentence
- `break_around_macro`: comma-separated list of names of macros that should be on their own line
- `break_before_macro`: comma-separated list of names of macros that should be preceded by a linebreak
- `break_after_macro`: comma-separated list of names of macros that should be succeeded by a linebreak
- `begin_protect [regex]`: If this regex matches a line, then all lines up to (including) the next line matched by `end_protect` remain unchanged.
- `begin_protect_sentences [regex]`: If this regex matches a line, then `latexbreak` will not try to break lines after sentences up to (including) the next line matched by `end_protect_sentences`.
- `begin_protect_sentences_inline [regex]`: For each match of this regex, `latexbreak` will not try to break lines after sentences up to the next match of `end_protect_sentences_inline` in the same line.
- `protect_break_after [regex]`: If a line matches this regex, then the linebreak at the end of this line will be preserved.
- `protect_break_before [regex]`: If a line matches this regex, then the linebreak before this line will be preserved.

## build

```
mvn package
```

## usage

```
java -jar latexbreak.jar $IN > $OUT
```
