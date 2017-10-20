interface CPU
{
  public void freq ();
}

class Lowfreq implements CPU
{
  public void freq()
  {
    System.out.println("The frequency of this CPU is 2.4 GHz");
  }
}

class Highfreq implements CPU
{
  public void freq()
  {
    System.out.println("The frequency of this CPU is 2.9 GHz");
  }
}

class CPUFactory
{
  public static CPU getCPU(String criteria)
  {
    if ( criteria.equals("low") )
      return new Lowfreq();
    else if ( criteria.equals("high") )
      return new Highfreq();

    return null;
  }
}

public class JavaFactoryPatternExample
{
  public static void main(String[] args)
  {
    CPU cpu = CPUFactory.getCPU("low");
    cpu.freq();

    cpu = CPUFactory.getDog("high");
    cpu.freq();

  }
}