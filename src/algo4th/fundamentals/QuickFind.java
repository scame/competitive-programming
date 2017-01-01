package algo4th.fundamentals;


public class QuickFind extends AbstractUnionFind {

    public QuickFind(int sitesNumber) {
        super(sitesNumber);
    }

    @Override
    public int find(int site) {
        return id[site];
    }

    @Override
    public void union(int firstSite, int secondSite) {
        int firstSiteComponent = find(firstSite);
        int secondSiteComponent = find(secondSite);

        if (firstSiteComponent != secondSiteComponent) {
            updateConnections(firstSiteComponent, secondSiteComponent);
            --componentsNumber;
        }
    }

    private void updateConnections(int firstSiteComponent, int secondSiteComponent) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == firstSiteComponent) {
                id[i] = secondSiteComponent;
            }
        }
    }
}
