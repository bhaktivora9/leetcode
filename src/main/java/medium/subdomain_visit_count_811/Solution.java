package medium.subdomain_visit_count_811;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		String[] cpdomains = new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		Solution s = new Solution();
		System.out.println(s.subdomainVisits(cpdomains));;
	}

	public List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String domainName : cpdomains) {

			String[] split = domainName.split(" ");
			Integer x = Integer.valueOf(split[0]);

			String domain = split[1];
			String[] domains = domain.split("\\.");
			String sb = "";
			for (int i = domains.length - 1; i >= 0; i--) {
				String subDom = domains[i];
				if (!sb.isBlank()) {
					subDom = subDom + "." + sb;
				}
				if (map.containsKey(subDom)) {
					map.put(subDom, map.get(subDom) + x);
				} else {

					map.put(subDom, x);
				}
				sb = subDom;
			}

		}

		List<String> collect = map.entrySet().stream().map(e -> e.getKey() + " " + e.getValue())
				.collect(Collectors.toList());

		return collect;

	}

}
