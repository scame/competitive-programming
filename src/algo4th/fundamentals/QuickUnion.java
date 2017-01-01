package algo4th.fundamentals;


public class QuickUnion extends AbstractUnionFind {

    public QuickUnion(int sitesNumber) {
        super(sitesNumber);
    }

    @Override
    public int find(int site) {
        while (id[site] != site) {
            site = id[site];
        }
        return site;
    }

    @Override
    public void union(int firstSite, int secondSite) {
        int firstSiteRoot = find(firstSite);
        int secondSiteRoot = find(secondSite);

        if (firstSiteRoot != secondSiteRoot) {
            id[firstSiteRoot] = secondSiteRoot;
            --componentsNumber;
        }
    }
}
