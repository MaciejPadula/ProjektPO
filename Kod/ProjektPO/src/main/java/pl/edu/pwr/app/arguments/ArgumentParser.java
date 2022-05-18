package pl.edu.pwr.app.arguments;

public class ArgumentParser {
    public ApplicationArguments parse(String[] args) {
        return new ApplicationArguments(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2],Integer.parseInt(args[3]),Integer.parseInt(args[4]));
    }
}
