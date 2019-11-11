/*
    *    KMeans.java
    *    Copyright (C) 2010 RWTH Aachen University, Germany
    *    @author Jansen (moa@cs.rwth-aachen.de)
    *
    *    This program is free software; you can redistribute it and/or modify
    *    it under the terms of the GNU General Public License as published by
    *    the Free Software Foundation; either version 3 of the License, or
    *    (at your option) any later version.
    *
    *    This program is distributed in the hope that it will be useful,
    *    but WITHOUT ANY WARRANTY; without even the implied warranty of
    *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    *    GNU General Public License for more details.
    *
    *    You should have received a copy of the GNU General Public License
    *    along with this program. If not, see <http://www.gnu.org/licenses/>.
    *
*/

import java.util.ArrayList;
import java.util.List;


public class KMeans {
    /**
     * K-Means Algorithm.
     * @param centers The cluster centers.
     * @param dataset The dataset.
     * @return Cluster centers.
     */
    public static List<double[]> kMeans(List<double[]> centers, List<double[]> dataset ) {
        // Get cluster sizes.
        int k = centers.length;

        // Initialize k clusters.
        List<List<double[]>> clustering = new ArrayList<List<double[]>>();
        for ( int i = 0; i < k; i++ ) {
            clustering.add( new ArrayList<double[]>() );
        }

        // K-means algorithm
        int repetitions = 100; // The maximum of iterations.
        double preTotalDistance = Integer.MAX_VALUE;
        double delta = 0.00001;
        double distanceDifference = Integer.MAX_VALUE;
        while ( repetitions-- >= 0 && distanceDifference > delta) {
            double currentTotalDistance = 0.0;

            // Assign points to clusters
            for ( double[] point : dataset ) {
                double minDistance = distance( point, centers.get(0) );

                int closestCluster = 0;
                for ( int i = 1; i < k; i++ ) {
                    double distance = distance( point, centers.get(i) );
                    if ( distance < minDistance ) {
                        closestCluster = i;
                        minDistance = distance;
                    }
                }

                currentTotalDistance += minDistance;
                clustering.get( closestCluster ).add( point );
            }

            distanceDifference = Math.abs(currentTotalDistance - preTotalDistance);
            preTotalDistance = currentTotalDistance;

            // Calculate new centers and clear clustering lists
            List<double[]> newCenters = new ArrayList<double[]>();
            for ( int i = 0; i < k; i++ ) {
                newCenters.add(calculateCenter( clustering.get( i ), k));
                clustering.get( i ).clear();
            }
            centers = newCenters;
        }

        return centers;
    }

    /**
     * Calculate euclidean distance between two points
     * @param pointA The point A.
     * @param pointB The point B.
     * @return The euclidean distance between A and B.
     */
    private static double distance(double[] pointA, double [] pointB){
        double distance = 0.0;
        for (int i = 0; i < pointA.length; i++) {
            double d = pointA[i] - pointB[i];
            distance += d * d;
        }

        return Math.sqrt(distance);
    }

    /**
     * Calculate cluster center
     * @param data The data.
     * @param clusterSize The cluster size.
     * @return The cluster center.
     */
    private static double[] calculateCenter( List<double[]> data, int clusterSize) {
        if (data == null || data.get(0).length == 0) {
            return null;
        }

        double[] res = new double[data.get(0).length];

        for ( int i = 0; i < data.size(); i++ ) {
            for (int j = 0; j < res.length; j++) {
                res[j] += data.get(i)[j];
            }
        }

        // Normalize
        for (int i = 0; i < res.length; i++) {
            res[i] /= clusterSize;
        }

        return res;
    }

    /**
     * The main program entry.
     * @param args The args for main function.
     */
    public static void main(String[] args) {
        System.out.println("K-Means Machine Learning");
    }
}