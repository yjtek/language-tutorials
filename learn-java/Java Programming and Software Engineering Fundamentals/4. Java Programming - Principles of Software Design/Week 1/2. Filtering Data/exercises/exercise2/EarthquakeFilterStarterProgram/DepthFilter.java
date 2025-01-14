package exercise2.EarthquakeFilterStarterProgram;

public class DepthFilter implements Filter {

    private double minDepthFilter;
    private double maxDepthFilter;
    private String filterName;

    public DepthFilter(double minDepth, double maxDepth, String name){
        minDepthFilter = minDepth;
        maxDepthFilter = maxDepth;
        filterName = name;
    }

    public boolean satisfies(QuakeEntry qe){
        if ((qe.getDepth() >= minDepthFilter) && (qe.getDepth() <= maxDepthFilter)) {
            return true;
        }
        return false;
    }

    public String getName(){
        return filterName;
    }
}