package algo4th.fundamentals;


public class WeightedQuickUnion extends AbstractUnionFind {

    protected int[] componentsSize;

    public WeightedQuickUnion(int sitesNumber) {
        super(sitesNumber);

        componentsSize = new int[sitesNumber];
        for (int i = 0; i < sitesNumber; i++) {
            componentsSize[i] = 1;
        }
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

        if (firstSite != secondSite) {
            updateRootConnections(firstSiteRoot, secondSiteRoot);
            --componentsNumber;
        }
    }

    private void updateRootConnections(int firstSiteRoot, int secondSiteRoot) {
        if (componentsSize[firstSiteRoot] < componentsSize[secondSiteRoot]) {
            componentsSize[secondSiteRoot] += componentsSize[firstSiteRoot];
            id[firstSiteRoot] = secondSiteRoot;
        } else {
            componentsSize[firstSiteRoot] += componentsSize[secondSiteRoot];
            id[secondSiteRoot] = firstSiteRoot;
        }
    }
}
