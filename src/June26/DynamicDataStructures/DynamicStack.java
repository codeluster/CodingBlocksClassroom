package June26.DynamicDataStructures;

import June19.Stack.Stack;

public class DynamicStack extends Stack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int cap) {
        super(cap);
    }

    @Override
    public void push(int item) throws Exception {

        if (super.size() == super.dataSource.length) {

            int[] oldData = super.dataSource;
            int[] newData = new int[oldData.length * 2];

            for (int i = 0; i < newData.length; i++) {
                newData[i] = oldData[i];
            }

            super.dataSource = newData;
        }

        super.push(item);
    }
}
