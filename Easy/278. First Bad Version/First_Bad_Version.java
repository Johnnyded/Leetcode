/**
 * First Bad Version is a Binary search problem that tests for the first case where a version/integer is bad in an array and returns its position in the array
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class First_Bad_Version extends VersionControl {
        public int firstBadVersion(int n) {
            int res = -1, left = 1, right = n;
            while (left <= right)
            {
                int pivot = left + (right - left);
                if (isBadVersion(pivot)) 
                {
                    res = pivot;
                    right = pivot - 1;
                }
                else left = pivot + 1;
            }
            return res;
        }

        public static void main(String[] args)
        {
            
        }
    }
    