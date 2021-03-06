/* -.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.

* File Name : MamaMia.java

* Purpose :

* Creation Date : 05-07-2011

* Last Modified : Wed 06 Jul 2011 03:23:37 PM EEST

* Created By : Greg Liras <gregliras@gmail.com>

_._._._._._._._._._._._._._._._._._._._._.*/

import java.util.LinkedList;


public class MamaMia
{
  public static void main(String[] input)
  {
    if(input.length != 6)
    {
      System.out.println("Usage: java MamaMia a m li hi lo ho");
    }
    else
    {
      int a = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      int li = Integer.parseInt(input[2]);
      int hi = Integer.parseInt(input[3]);
      int lo = Integer.parseInt(input[4]);
      int ho = Integer.parseInt(input[5]);
      int minLimit = Math.min((int) Math.floor(lo/a)
                        ,(int) (Math.floor(Math.log(lo)/Math.log(m))))-1;
      System.out.println(minLimit);
      int maxLimit = Math.min((int) Math.ceil(ho/a)
                        ,(int) (Math.ceil(Math.log(ho)/Math.log(m))));

      ProgramsGenerator test = new ProgramsGenerator(minLimit);
      test.fillProgList();
      LinkedList<String> Progs=null;
      for(int i = minLimit ; i<= maxLimit ; i++)
      {
        Progs = test.getProgList();
        for(String Prog:Progs)
        {
          Runner runner = new Runner(a,m,li,hi,Prog);
          runner.run();
          if(runner.outPutCheck(lo,ho))
          {
            if(Progs.size()==1)
            {
              System.out.println("empty");
            }
            else
            { 
              System.out.println(Prog);
            }
            return;
          }
        }
        test.makeMoreProgs();
      }
      System.out.println("impossible");
    }
  }
}
