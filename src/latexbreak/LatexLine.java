package latexbreak;

import java.util.*;

public class LatexLine {

    public LatexLine(String content) {
        this.content = content;
    }

    public String content;
    public boolean protectSentences;
    public boolean protect;
    public boolean lineComment;

    public LatexLine strip() {
        assert !protect;
        this.content = content.strip();
        return this;
    }

    public boolean isBlank() {
        return content.isBlank();
    }

    public boolean endsWith(String s) {
        return content.endsWith(s);
    }

    public boolean startsWith(String s) {
        return content.startsWith(s);
    }

    public boolean matches(String regex) {
        return content.matches(regex);
    }

    public LatexLine append(String s) {
        assert !protect;
        content += s;
        return this;
    }

    public LatexLine concat(LatexLine that) {
        assert this.protectSentences == that.protectSentences;
        assert !this.protect;
        assert !that.protect;
        this.content += that.content;
        return this;
    }

    @Override
    public LatexLine clone() {
        var res = new LatexLine(content);
        res.protectSentences = protectSentences;
        res.protect = protect;
        return res;
    }

    public List<LatexLine> split(String regex) {
        assert !protect;
        var res = new ArrayList<LatexLine>();
        for (var s: content.split(regex)) {
            var l = clone();
            l.content = s;
            res.add(l);
        }
        return res;
    }

    @Override
    public String toString() {
        return content;
    }

    public List<LatexLine> replaceAll(String regex, String replacement) {
        assert !protect;
        var str = content.replaceAll(regex, replacement);
        var res = new ArrayList<LatexLine>();
        for (var s: str.split(LatexBreak.newline)) {
            var clone = clone();
            clone.content = s;
            res.add(clone);
        }
        return res;
    }

    public int length() {
        return content.length();
    }

    public char charAt(int i) {
        return content.charAt(i);
    }

    public LatexLine substring(int beginIndex, int endIndex) {
        this.content = content.substring(beginIndex, endIndex);
        return this;
    }

    public LatexLine setContent(String content) {
        this.content = content;
        return this;
    }
}
