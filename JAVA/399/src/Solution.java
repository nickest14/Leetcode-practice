import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Solution {
	public static void main(String args[]) {

		String[][] equations = new String[4][2];
		equations[0][0] = "a";
		equations[0][1] = "d";
		equations[1][0] = "d";
		equations[1][1] = "c";
		equations[2][0] = "c";
		equations[2][1] = "b";
		equations[3][0] = "b";
		equations[3][1] = "e";

		// equations[0][0] = "c";
		// equations[0][1] = "b";
		// equations[1][0] = "a";
		// equations[1][1] = "b";
		// equations[2][0] = "a";
		// equations[2][1] = "b";
		// equations[3][0] = "b";
		// equations[3][1] = "e";

		double[] values = { 40, 2, 5, 4 };

		String[][] queries = new String[4][2];

		queries[0][0] = "a";
		queries[0][1] = "c";
		queries[1][0] = "b";
		queries[1][1] = "a";
		queries[2][0] = "a";
		queries[2][1] = "e";
		queries[3][0] = "a";
		queries[3][1] = "a";

		double[] Ans = new double[queries.length];
		Ans = calcEquation(equations, values, queries);
		for (int i = 0; i < queries.length; i++)
			System.out.println(Ans[i]);
	}

	static Map<String, Map<String, Double>> map = new HashMap<>();

	public static double[] calcEquation(String[][] equations, double[] values,
			String[][] query) {
		Set<String> set = new HashSet<String>();
		Map<String, Double> m = new HashMap<String, Double>();
		for (int i = 0; i < equations.length; i++) {
			set.add(equations[i][0]);
			set.add(equations[i][1]);

			if (map.containsKey(equations[i][0]))
				m = map.get(equations[i][0]);
			else
				m = new HashMap<String, Double>();
			m.put(equations[i][1], values[i]);
			map.put(equations[i][0], m);

			if (map.containsKey(equations[i][1]))
				m = map.get(equations[i][1]);
			else
				m = new HashMap<String, Double>();
			m.put(equations[i][0], 1 / values[i]);
			map.put(equations[i][1], m);
		}
		double[] result = new double[query.length];
		for (int i = 0; i < query.length; i++) {
			Map<String, Boolean> visit = new HashMap<String, Boolean>();
			Iterator<String> s = set.iterator();
			while (s.hasNext())
				visit.put(s.next(), false);
			if (set.contains(query[i][0]) && query[i][0] == query[i][1]) {
				result[i] = 1;
				continue;
			}
			result[i] = DFS(query[i][0], query[i][1], 1, visit);
		}

		return result;
	}

	public static double DFS(String s, String t, double result,Map<String, Boolean> visit) {
		if (map.containsKey(s) && !visit.get(s)) {
			visit.put(s, true);
			Map<String, Double> m = map.get(s);
			if (m.containsKey(t))
				return result * m.get(t);
			else {
				Iterator<String> c = m.keySet().iterator();
				while (c.hasNext()) {
					String key = c.next();
					double tempresult = DFS(key, t, result * m.get(key), visit);
					if (tempresult != -1)
						return tempresult;
				}
			}
		} else
			return -1;
		return -1;

	}
}