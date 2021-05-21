
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.IOException;


class Parser {

    @Option(name = "-u", usage = "unpacking file", forbids = {"-z"})
    private boolean unpack = false;

    @Option(name = "-z", usage = "packing file", forbids = {"-u"})
    private boolean pack = false;

    @Option(name = "-out", usage = "output to this file (default: inputname.txt)", metaVar = "OUTPUT")
    private String out;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) {
        new Parser().launch(args);
    }



    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
            if ((arguments.isEmpty()) || (!arguments.get(0).equals("ciphxor"))) {
                System.err.println("Error entering arguments (for correct input, see the example)");
                System.err.println("pack-rle [options...] arguments...");
                parser.printUsage(System.err);
                System.err.println("Example:  pack-rle [-u|-z] [-out outputname.txt] inputname.txt");
                throw new IllegalArgumentException("");
            }
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Example:  pack-rle [-u|-z] [-out outputname.txt] inputname.txt");
            parser.printUsage(System.err);
            return;
        }


        Packrle toPack = new Packrle();
        toPack.packRLE(pack, arguments.get(1), out);

    }
}
