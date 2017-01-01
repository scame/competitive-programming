package algo4th.fundamentals;


public abstract class AbstractUnionFind {

    protected int[] id;
    protected int componentsNumber;

    public AbstractUnionFind(int sitesNumber) {
        this.componentsNumber = sitesNumber;

        id = new int[sitesNumber];
        for (int i = 0; i < sitesNumber; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return componentsNumber;
    }

    public boolean isConnected(int firstSite, int secondSite) {
        return find(firstSite) == find(secondSite);
    }

    public abstract int find(int site);

    public abstract void union(int firstSite, int secondSite);
}
