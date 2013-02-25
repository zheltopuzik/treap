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
		currentTreapMap.put(1, "one2");
		currentTreapMap.remove(3);	
		currentTreapMap.remove(6);
		currentTreapMap.put(6, "six1");
		currentTreapMap.put(6, "six2");
		assertEquals(currentTreapMap.get(1), "one2");
		assertEquals(currentTreapMap.get(5), "five");
		assertEquals(currentTreapMap.get(6), "six2");
		assertNull(currentTreapMap.get(7));
	}
	
	public void test2()
	{
		TreapMap<Integer, Integer> currentTreapMap = new TreapMap<Integer, Integer>();		
		
		for (Integer i = 1; i <= 100000; i++)
			currentTreapMap.put(i, i);
		
		for (Integer i = 1; i <= 100000; i++)
			currentTreapMap.put(i, i+1);
		
		for (Integer i = 1; i <= 100000; i++)
		{
			Integer j = i + 1;
			assertEquals (currentTreapMap.get(i), j);	
		}
		
		for (Integer i = 1; i <= 100000; i++)
			currentTreapMap.remove(i);
		
		for (Integer i = 1; i <= 100000; i++)
			assertNull (currentTreapMap.get(i));
				
	}
		
	public void test3() throws UnsupportedOperationException
	{
		TreapMap<Integer, Double> currentTreapMap = new TreapMap<Integer, Double>();
		try
		{
			currentTreapMap.put(5, 5.0);	
			assertEquals(currentTreapMap.size(), 1);
			
			currentTreapMap.put(6, 6.2);
			assertEquals(currentTreapMap.containsValue(6.2), true);
			
			currentTreapMap.put(6, 6.5);
			assertEquals(currentTreapMap.get(6), 6.5);
			currentTreapMap.remove(5);
			assertEquals(currentTreapMap.isEmpty(), false);
			
			currentTreapMap.remove(6);
	
			assertEquals(currentTreapMap.isEmpty(), true);
			assertNull (currentTreapMap.get(5));

		}
		catch (UnsupportedOperationException msg)
		{
			System.out.println("Exception: " + msg);
		}
	}
}
