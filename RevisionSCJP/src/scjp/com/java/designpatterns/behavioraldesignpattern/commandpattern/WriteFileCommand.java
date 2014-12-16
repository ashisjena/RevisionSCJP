package scjp.com.java.designpatterns.behavioraldesignpattern.commandpattern;

public class WriteFileCommand implements Command
{
    private FileSystemReceiver fileSystem;

    public WriteFileCommand( FileSystemReceiver fs )
    {
        this.fileSystem = fs;
    }

    @Override
    public void execute()
    {
        this.fileSystem.writeFile();
    }

}