/**
 * Write a description of class Chain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Chain 
{
    public void setNext(Chain nextInChain);
    public void start(Announcement ann);
}
