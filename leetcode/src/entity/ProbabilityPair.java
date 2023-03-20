package entity;

/**
 * @author hanrensong
 * @date 2021/8/12
 */

public class ProbabilityPair implements Comparable<ProbabilityPair> {
    public double probability;
    public int node;

    public ProbabilityPair(double probability, int node) {
        this.probability = probability;
        this.node = node;
    }

    @Override
    public int compareTo(ProbabilityPair probabilityPair2) {
        if (this.probability == probabilityPair2.probability) {
            return this.node - probabilityPair2.node;
        } else {
            return this.probability - probabilityPair2.probability > 0 ? -1 : 1;
        }
    }
}
