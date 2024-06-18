
import java.util.List;

public class Perm {
  public void nextPermutation(List<Integer> perm) {
    int lastIndex = perm.size() - 1;
    int piIndex = lastIndex;
    while (piIndex > 0 && perm.get(piIndex) < perm.get(piIndex - 1)) {
      piIndex--;
    }
    piIndex--;
    int pi = perm.get(piIndex);
    int pjIndex = piIndex + 1;
    for (int i = pjIndex; i <= lastIndex; i++) {
      if (perm.get(i) > pi && perm.get(i) < perm.get(pjIndex)) {
        pjIndex = i;
      }
    }
    int tmp = perm.get(pjIndex);
    perm.set(pjIndex, perm.get(piIndex));
    perm.set(piIndex, tmp);

    for (int i = piIndex + 1, j = lastIndex; i < j; i++, j--) {
      tmp = perm.get(j);
      perm.set(j, perm.get(i));
      perm.set(i, tmp);
    }
  }
}