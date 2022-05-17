package pl.edu.pwr.app;

public class ArgumentParser {

public ApplicationArguments parse(String[] args)
{
    return new ApplicationArguments(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
}
}
