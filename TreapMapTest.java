import junit.framework.TestCase;


public class TreapMapTest extends TestCase
{
  
	public void test1()
	{
		TreapMap<Integer, String> currentTreapMap = new TreapMap<Integer, String>();
		currentTreapMap.put(5, "five");
		currentTreapMap.put(6, "six");
		currentTreapMap.put(1, "one");
		currentTreapMap.remove(1);
		currentTreapMap.put(1, "one1");
		currentTreapMap.remove(3);	
		currentTreapMap.remove(6);
		currentTreapMap.put(6, "six1");
		
		assertEquals(currentTreapMap.get(1), "one1");
		assertEquals(currentTreapMap.get(5), "five");
		assertEquals(currentTreapMap.get(6), "six1");
		assertNull(currentTreapMap.get(7));
	}
	
	public void test2()
	{
		TreapMap<Integer, Integer> currentTreapMap = new TreapMap<Integer, Integer>();		
		
		for (Integer i = 1; i <= 100000; i++)
			currentTreapMap.put(i, i);
		
		for (Integer i = 1; i <= 100000; i++)
			assertEquals (currentTreapMap.get(i), i);	
	}
		
	public void test3()
	{
		TreapMap<Integer, String> currentTreapMap = new TreapMap<Integer, String>();		
		currentTreapMap.putNextPriority(2);
		currentTreapMap.put(5, "5");
		
		currentTreapMap.putNextPriority(4);
		currentTreapMap.put(3, "3");
		
		currentTreapMap.putNextPriority(1);
		currentTreapMap.put(10, "10");
		
		currentTreapMap.remove(3);
		
		assertEquals (currentTreapMap.get(10), "10");
		assertNull(currentTreapMap.get(3));
		
	}
	
	public void test4()
	{
		TreapMap<Integer, String> currentTreapMap = new TreapMap<Integer, String>();		
		currentTreapMap.putNextPriority(8);
		currentTreapMap.put(6, "6");
		
		currentTreapMap.putNextPriority(6);
		currentTreapMap.put(5, "5");
		
		currentTreapMap.putNextPriority(7);
		currentTreapMap.put(4, "4");
		
		currentTreapMap.putNextPriority(4);
		currentTreapMap.put(3, "3");

		currentTreapMap.putNextPriority(10);
		currentTreapMap.put(2, "2");
		
		currentTreapMap.putNextPriority(5);
		currentTreapMap.put(1, "1");

		currentTreapMap.remove(6);
		
		assertEquals (currentTreapMap.get(4), "4");
		
		currentTreapMap.remove(4);
		currentTreapMap.remove(2);
		
		assertEquals (currentTreapMap.get(5), "5");
		assertEquals (currentTreapMap.get(1), "1");
		assertNull(currentTreapMap.get(2));
		assertNull(currentTreapMap.get(4));		
	}
	
}
