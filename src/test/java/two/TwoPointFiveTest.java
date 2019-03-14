package two;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPointFiveTest {

    @Test
    public void test_id_checker() {
        String[] idList = {"abcde", "fghij", "klmno", "pqrst", "fgnij", "axcye", "wvxyz"};
        assertEquals("hn", idChecker(idList));
    }

    @Test
    public void test_id_checker_2() {
        String[] idList = {"lsrivfotzgdxpkefaqmuiygchj", "lsrivfotzqdxpkeraqmewygchj", "lsrivfotzbdepkenarjuwygchj", "lsrivfotwbdxpkeoaqmunygchj", "lsrijfotzbdxpkenwqmuyygchj", "lsrivfotzbdxpkensqsuwygcdj", "lsrivfotubdxpkenzqmuwyschj", "lsrjvwotzbdxpkenaqjuwygchj", "lsrtvfotzbdxpkeaaqmuqygchj", "lscivzotzbdxpkenaqmuwygcnj", "ddrivfotzbdxpkenlqmuwygchj", "jsrivfvtzbdxpkenaqmufygchj", "csrivfotzxdxpkenaqguwygchj", "lprivfbtzbqxpkenaqmuwygchj", "lsrnvfotzbnxpkenaqmuwygchk", "lsiivfotzbdhpkencqmuwygchj", "lsrivfotzbyxpkenaqmzwygchc", "lsjivfotqbdxpvenaqmuwygchj", "lsrivfotzbdxpkencqmuwvgqhj", "lsrivfotzhdxpqenaqouwygchj", "lsrivfytzbnxpkenaqmuwygcsj", "llrivfotzbdxpkenaqmuwynchd", "lsuivfotzbdxpnenaqmuwygchk", "lsrtvootnbdxpkenaqmuwygchj", "ysrivfotzcdxpkenaqmuwhgchj", "lsrivfotxbdxpkefgqmuwygchj", "lsrmvfotzbaxpkenaqmuwygfhj", "lsrivfothbyxpkxnaqmuwygchj", "isrivfotzbdxpkenaqmkwygcht", "lhrivfotzbdxpkbnfqmuwygchj", "lsrivfotzbmxpkenaqmuwbgdhj", "lsrivvotzbdxcoenaqmuwygchj", "ssrwvfotzbdjpkenaqmuwygchj", "lsrivfotgbwxpkenaqmhwygchj", "lsrivfotzbdxpkenaqcuhygcyj", "lcdivfotzbdxpkenaqmuwxgchj", "ysbivfotzbdxpkenaqmuwkgchj", "lsrivfltzbdxxkenaqcuwygchj", "lsrivfotzbdxpkgnaqmunegchj", "fsqpvfotzbdxpkenaqmuwygchj", "lsriifotzbcxpkenaqmubygchj", "lsrivfotzjdxpkenaqmugygcjj", "tsrikfotzbdxpkeneqmuwygchj", "larivfotzbdxpkenaqmwwygcpj", "larivfotzbdxpkenaqmuayrchj", "lsravfotzbdxpkdoaqmuwygchj", "lsrivfotzbixpkenaqvtwygchj", "lsrixfotnbdxtkenaqmuwygchj", "lsrirfotzbdxpkeneqmuwygchv", "lsrivfofzedxpkenaqmswygchj", "lwrivfotzvdxpkenaqmuwygfhj", "lsrivfotzbdapkenaqmuqygehj", "lsrizfotgbdxpkenaqjuwygchj", "lsrivioxzbdxpkanaqmuwygchj", "lsrivfmtzbdxpkgnaqmuwcgchj", "lsrivfotzbdxpkeaaqmuofgchj", "lsrivfotvbdxpkenuqmuwygcht", "lsrivfothcdxpkenaqouwygchj", "lsgivfotzbdxpkenawmuwygchi", "lsrigfotzbdxpmonaqmuwygchj", "lsrivfotzbdxrkfnaqmuwygcha", "lsrivfopobdxpkenaqmuwygchv", "lsrejfotzbdxpkvnaqmuwygchj", "lsrivfotzbdxplenqqmuwygchz", "lsmivfotzbdppkebaqmuwygchj", "lsrivfotubdipkewaqmuwygchj", "lsrivfodnbhxpkenaqmuwygchj", "lsrivfotzbdxpkenaqmkwzgshj", "lsrixfotzbdxpkensqmuwygohj", "lsdivfotzbdxpkenaqmuwagcwj", "lsrimfotzbdxpkenaqmuwygcyu", "asnivfotzbdxpkenaqmbwygchj", "lseivfltfbdxpkenaqmuwygchj", "lsrivfbtzbdxpuenaqmuwyychj", "lsziafozzbdxpkenaqmuwygchj", "lsrivfotzbdxpkwnaomuwygchg", "ldrivfotzbdxpkeniqmuwygihj", "lsrivfotzbdxpkenaqhdwycchj", "lsrigfotzbdxphenaqmuwynchj", "lsripfotzbdxpgenaqmuwygchh", "lsrgvfoczbdxpkenaqmuwygihj", "lsribfotzbgxpkenaqhuwygchj", "lsrkvfotztdxpienaqmuwygchj", "lsrivfohzbdxpkenaqrxwygchj", "lsrivfoszbdxpkenavmuwygvhj", "lsrivfstzblxpkcnaqmuwygchj", "lzrivfotzbdxpkegaqmuwygchv", "lsrivtotzbdxpkenaqrumygchj", "lsgivfotzbdwpkenaqmuwhgchj", "lurivfotybdxpkenaqmuwygchg", "lsrivfogzbdxpkmnrqmuwygchj", "lsrivgotzbdxpkengqmuwygcwj", "lirivfbyzbdxpkenaqmuwygchj", "lwrivfotzbdxpkbjaqmuwygchj", "lsrivkotzbqxakenaqmuwygchj", "lxrivfotzbdxpkenaqmuwygshy", "lxxivfqtzbdxpkenaqmuwygchj", "lsrivfohzbdxpzenaqmuzygchj", "lsrivfotzndxekenaqmuwygcvj", "lsrdvfotzbdxpkenaqguiygchj", "lsrivfotzbdxpiehaqauwygchj", "atrivfotzbdxpkenaqmuwygchz", "lsrivfovzbdxpkenaqmuvygcwj", "lsrivfotzmdxpkennqmuwyxchj", "luvcvfotzbdxpkenaqmuwygchj", "lsriqfotzbdxpbenaqmuwygchg", "bsoivfotzudxpkenaqmuwygchj", "lsrivfotzbdxphenaqmhwxgchj", "lsrivfotzbdxpkenasmuwjgchw", "lsrivdotzboxpkenaqmuwykchj", "lsqivfotzbdxcdenaqmuwygchj", "lsrivfktzndypkenaqmuwygchj", "lwrivfotzbdxpkenaqmuolgchj", "lkrivfowzbdxpkenaqmbwygchj", "lsrivhotzbdxpkenaqyuwygvhj", "lsruvfotzbdxpkecaqmukygchj", "lsrivdotzbdsskenaqmuwygchj", "lsrivfotzbdxpkanaqmuwygcmc", "lsrgvfotubdxpkenrqmuwygchj", "psrivfotzbdxpkenaqmutygchd", "lsrivfitzbdxpkenagmiwygchj", "lsrivfotzbdxpkbnaqauwyrchj", "lsrivfotvbdxpjenaqmuwygchr", "lsrdvfoyzbjxpkenaqmuwygchj", "vsrivfothbdxpkenaqmuwyychj", "lyrivfotzpdxpkepaqmuwygchj", "lsgbqfotzbdxpkenaqmuwygchj", "lxrivfotzbdxpkenegmuwygchj", "lsrivfokzbdxpkenaqnuwyxchj", "lsrivfotubmxpkexaqmuwygchj", "lswivfvtzbdxpkenaqmuwygcgj", "lsrivfonzbdxpkenaqiuwygchc", "isrivlotzbdxpkenaqmuwygchf", "lsrilfozzbdxpkenaqmuwygcvj", "wsrivfotzbdxpkepaqmuwegchj", "lsrivfrtzbrxpkenaqquwygchj", "lsrivfotzbdxpkeqaqmuoygjhj", "lsrivfotzmdxpkenaqmuwyxchg", "lsrnvfotzbzxxkenaqmuwygchj", "ldrivfotzbdxpkenaqmlxygchj", "lsriofotzbdxpkenaqmwwmgchj", "lsrivfotzodxjkenaqmuwyglhj", "lsriviotzbdxpkegaqguwygchj", "lsrimfotzbdxpkanaqmuwygshj", "lwrzvfotzbdxpkenaqmuwygcfj", "lirivfotzbdxkkenvqmuwygchj", "lsrivfotlbdxpkeoaqmuwygahj", "lsxivfotzbdxpkenaqmuwwgchi", "lsrivfotzbdxpkenaqmukygzzj", "lsrtvfotzbdxskenaqmuwygcij", "lsgilfotzbdxpdenaqmuwygchj", "lsriyfotbbdxpkenaqmuwygchm", "lsrivfotabdxpkenaqmuwyghhs", "xsrizfotzbdxpkenaqmuwygczj", "lsrivfotybdxpkenaqquwygchx", "lsrzvfofzbdxpktnaqmuwygchj", "xsripfotzbdxpkenaqmqwygchj", "lsrivfotzbdspkenahmuwugchj", "lsmivfotzbdbpkenaqmuwygchy", "lsruvfotzbdxpkenaqqpwygchj", "lrmivfotzbdxpkenaqguwygchj", "lsnivfotzbdlpketaqmuwygchj", "lsrivfotzbdxjketaqjuwygchj", "lsrivxotzbdchkenaqmuwygchj", "lsrivootzbdxpkenaqmuwybmhj", "tsrivfdtzbdxpkenaqmuwpgchj", "lsrivmotzbdxpkxnaqmuwcgchj", "lsrivfotzadepkenaqmuwyichj", "dsrivfotrbdxpkenaqmuwtgchj", "lsrivfhtzbdxvkenoqmuwygchj", "lsrivfotzvdxbkenaqmbwygchj", "lsrxvcotzbdxpkenaqmuwygvhj", "lsrivfotzbdxykenaqmuwfgcha", "lsbivfotzbdxpkenaqmuwfvchj", "lfrivfotzbdcpkgnaqmuwygchj", "lsrivfotzbdxpwegdqmuwygchj", "lsrivfotyjdupkenaqmuwygchj", "gsrivfotzbdxpkenaemuwcgchj", "lsrivfodqbdxpkenaqmuwygchg", "lsrivfoczbdxpkenaqnuwwgchj", "lsrivpouzbhxpkenaqmuwygchj", "llbivuotzbdxpkenaqmuwygchj", "lfrivfofzbdxpkenaqmuwygchb", "lsrivfotzbdxpkenaumuwgghhj", "lsrivfotzbdxqaenazmuwygchj", "lsrivfotzbgxpkenkqmqwygchj", "lsrivfotzbdxpkensqiawygchj", "ljrijfotzbdxppenaqmuwygchj", "lsrivfoszbdxpkrnlqmuwygchj", "lsrijfotzbdxpcfnaqmuwygchj", "lsrivfotzbdopkebaqmuwytchj", "lsrivfonzbdxnkenalmuwygchj", "larivfouzbvxpkenaqmuwygchj", "lsryvfotzbdxpkensqmuwygyhj", "lsrivfztzbdxpkenaxmuwigchj", "lqkivfotzbdxpkenaqmuwygcht", "wsdivfotzbdxpkenbqmuwygchj", "lsrlvfotzadxpkencqmuwygchj", "lsrivfotoohxpkenaqmuwygchj", "lsrivfbuzbdfpkenaqmuwygchj", "psrivfotzbdxpkenawmuqygchj", "lsrivmotzbdxpkxnaqmuwcychj", "lsrivfotzvdgpkenaqmuwlgchj", "lcfivfstzbdxpkenaqmuwygchj", "lsrivfotzbddpkeeaqmuwygcij", "lsribfotzbdxpkenaqmuwugcyj", "lsrivfotzbdxakenaqmkwygyhj", "lsrivfotzbdxpkegaqmupyvchj", "lfrivfitzbdxpkenaqmuwygcrj", "lskivfotzbdxpkenaqmuwygwwj", "lsrivfotzddnpkenaqmuwfgchj", "lsrivfotzbdiukhnaqmuwygchj", "lfrivfotzbdxpkendqmuwygctj", "ljriqfotzvdxpkenaqmuwygchj", "lsrivfotzbdxpkeskqpuwygchj", "lsrivfotzbdxpkehaqmupygghj", "lsriyfotsbdxpkedaqmuwygchj", "lsrivfotzbdsjsenaqmuwygchj", "lsrivfotzbwxpienaqmuaygchj", "lsrivrotzbdxpkenaumuwygahj", "lsrivpotzfdxpkenaqmuwyjchj", "lsrivfomebdxpoenaqmuwygchj", "lswigfotpbdxpkenaqmuwygchj", "lsrivnotzbdxpkenaqmufrgchj", "lsrivfolbbdxpkenaqmuwygcqj", "lirivfotzbdxpknnaqeuwygchj", "lsrrvfxtzbdxpaenaqmuwygchj", "lspivfotzbdxpnsnaqmuwygchj", "lsrivfotzbyxpkenaqmawygcij", "lsrivfotzbfxpbenaqmuwyichj", "lsrivfotzbvxpjeyaqmuwygchj", "lyrihfotzbdxpknnaqmuwygchj", "uurivfotzbdxpkenaqmubygchj", "lsrivfotgbdxnkenaxmuwygchj", "lsriffotzbdxpkdnaqmuwygshj", "lsrisfotzbdxpkenaqzjwygchj", "lsrilfotzbdxpkenaqmuwygtgj", "lsrivfotzbdxzkenaqmuhmgchj", "hsrivfotzbdxprenaqauwygchj", "tsrevfotzbdupkenaqmuwygchj", "lsrizfotzbpxpkenaqmuwyrchj", "lsdivfotzbxxpkenaqmuhygchj", "lsrivfttzbyxpkenaqmuaygchj", "lsrivfotzodxpwenaqzuwygchj", "lsrivfotfbdxpkenaqvuwygyhj", "lsrivfotzzdxpknnaqmulygchj", "lsrjvvotzbdxpkenaqmuwjgchj", "lsrivuotzbdxpkeiaqxuwygchj", "lsrivfotzbdxpzenaqmmwygthj", "lsrivfotzbdxphenaqmuwyghv"};
        assertEquals("gy", idChecker(idList));
    }

    @Test
    public void test_compare_strings() {
        assertEquals("", compareStrings("abcde", "abcde"));
        assertEquals("ck", compareStrings("abcde", "abkde"));
        assertEquals("ck ef", compareStrings("abcde", "abkdf"));
        assertEquals("ck ef op", compareStrings("abcdelmo", "abkdflmp"));
        assertEquals("-", compareStrings("abcde", "abcd"));
    }

    @Test
    public void test_doStringsDifferByOneLetterOnly() {
        assertFalse(doStringsDifferByOneLetterOnly("abcde", "abcde"));
        assertFalse(doStringsDifferByOneLetterOnly("abcde", "abkdf"));
        assertFalse(doStringsDifferByOneLetterOnly("abcdelmo", "abkdflmp"));
        assertFalse(doStringsDifferByOneLetterOnly("abcde", "abcd"));
        assertTrue(doStringsDifferByOneLetterOnly("abcde", "abkde"));
    }

    private String idChecker(String[] idList) {

        String result = "";
        for (String id : idList) {
            for (int i = Arrays.asList(idList).indexOf(id)+1; i < idList.length; i++) {
                if (doStringsDifferByOneLetterOnly(id, idList[i])) {
                    result += compareStrings(id, idList[i]);
                    System.out.println(id + " " + idList[i]);
                }
            }
        }
        return result;
    }

    public String compareStrings(String first, String second) {
        if (first.length() != second.length()) {
            return "-";
        }

        StringBuilder diff = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (diff.length() != 0) {
                    diff.append(" ");
                }

                diff.append(first.charAt(i)).append(second.charAt(i));
            }
        }

        return diff.toString();
    }

    public boolean doStringsDifferByOneLetterOnly(String first, String second) {
        String differences = compareStrings(first, second);
        return differences.length() == 2;
    }
}