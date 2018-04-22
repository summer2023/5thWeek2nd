package tw.core.model;

public class Record {
    private int[] value;

    public Record() {
        this.value = new int[]{0, 0};

    }

    public int[] getValue() {
        return value;
    }

    public void increaseCurrentNum() {
        this.value[0]++;
    }

    public void increaseIncludeOnlyNum() {
        this.value[1]++;
    }

    @Override
    public boolean equals(Object anObject) {

        if(anObject instanceof Record)
        {
            if(((Record)anObject).value[0] == this.value[0] && ((Record)anObject).value[1] == this.value[1])
                return true;
        }
        return false;
    }
}
