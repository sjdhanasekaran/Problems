
import java.io.PrintWriter;
import java.util.Arrays;

public class Java {

    public static void main(String[] args) throws Exception {

/*
        Options options = new Options();

        Option insDirectory = new Option("i", "install-Directory", true, "installation direction");
        insDirectory.setRequired(true);
        insDirectory.setArgName("directory");
        options.addOption(insDirectory);

        Option hostName = new Option("h", "host-names", true, "provide hostname or ip address separated by \";\"");
        hostName.setRequired(true);
        hostName.setArgs(Option.UNLIMITED_VALUES);
        hostName.setValueSeparator(';');
        hostName.setArgName("hostnames");
        options .addOption(hostName);

        Option accPort = new Option("a", "acc-port", true, "accPort to detect the installation type");
        accPort .setArgName("ACC port");
        options .addOption(accPort);

        Option runnableList = new Option("r", "runnable-list", true, "accPort to detect the installation type");
        runnableList.setArgs(Option.UNLIMITED_VALUES);
        accPort .setRequired(true);
        runnableList.setValueSeparator(';');
        runnableList.setArgName("Runnables You have to Configure In each node with separated node specific as \";\" and runnable specific separated by \",\"");
        options.addOption(runnableList);

        Option type= new Option("t", "type", true, "Installation type inorder to identify the runnables");
        type.setArgName("Installation Type");
        options.addOption(type);

        Option start= new Option("start", false, "Start Clustering");
        options.addOption(start);

        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();
        CommandLine commandLine;
        try {
            commandLine = commandLineParser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            helpFormatter.printHelp("java -jar", options);
            System.exit(1);
            return;
        }
        String[] host=null;
        String[] runnables=null;
        String insDir=null;
        String typ;
        String acc=null;
            if (commandLine.hasOption("h")) {
                host = commandLine.getOptionValues('h');
            }
            if (commandLine.hasOption("r")) {
                runnables = commandLine.getOptionValues('r');
            }
            if (commandLine.hasOption("i")) {
                insDir = commandLine.getOptionValue('i');
            }
            if (commandLine.hasOption("t")) {
                typ = commandLine.getOptionValue('t');
            } else {
                typ = "s";
            }
            if (commandLine.hasOption("a")) {
                acc = commandLine.getOptionValue('a');
            }
            if(commandLine.hasOption("start")){
                if(!(host==null&&runnables==null&&insDir==null&&typ==null&&acc==null)){
                    helpFormatter.printHelp("java -jar", options);
                    System.exit(1);
                }else{
                    JSONArray hostArray =   new JSONArray();
                    for (int i = 0; i < ((host != null) ? host.length : 0); i++) {
                        JSONObject json = new JSONObject();
                        json.put("ip", host[i]);
                        assert runnables!=null;
                        String runnableString=runnables[i];
                        String[] nodeRunnables=runnableString.split(",");
                        JSONArray runnableArray=new JSONArray();
                        runnableArray.addAll(Arrays.asList(nodeRunnables));
                        json.put("n"+String.valueOf(i+1),runnableArray);
                        hostArray.add(json);
                    }

                    PrintWriter p = null;
                    if (System.getProperty("os.name").toLowerCase().contains("win")) {
                        p = new PrintWriter(insDir + "API_Portal\\server\\nodes.json");

                    } else if (System.getProperty("os.name").toLowerCase().contains("lin")) {
                        p = new PrintWriter(insDir + "API_Portal/server/nodes.json");
                    }

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("installedDirectory", insDir);
                    jsonObject.put("accPort",acc);
                    jsonObject.put("installationType",typ);
                    jsonObject.put("nodes",hostArray);

                    assert p != null;
                    try {
                        jsonObject.writeJSONString(p);
                        p.flush();
                        p.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
*/

        }
    }
/*

    //***Parsing Stage***
    //Create a parser
    CommandLineParser parser = new DefaultParser();

    //parse the options passed as command line arguments
    CommandLine cmd = parser.parse( options, args);


//***Interrogation Stage***
//hasOptions checks if option is present or not
        if(cmd.hasOption("a")) {
                System.out.println("Sum of the numbers: " + getSum(args));
                } else if(cmd.hasOption("m")) {
                System.out.println("Multiplication of the numbers: " + getMultiplication(args));
                }
                }

public static int getSum(String[] args) {
        int sum = 0;
        for(int i = 1; i < args.length ; i++) {
        sum += Integer.parseInt(args[i]);
        }
        return sum;
        }

public static int getMultiplication(String[] args) {
        int multiplication = 1;
        for(int i = 1; i < args.length ; i++) {
        multiplication *= Integer.parseInt(args[i]);
        }
        return multiplication;
        }*/
