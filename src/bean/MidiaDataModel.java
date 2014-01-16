package bean;

import java.util.List;

import javax.faces.model.ListDataModel;

import model.Midia;

import org.primefaces.model.SelectableDataModel;

public class MidiaDataModel extends ListDataModel<Midia> implements SelectableDataModel<Midia> {
	
	public MidiaDataModel(){}
	
	public MidiaDataModel(List<Midia> midias)
	{
		super(midias);
	}
	
	@Override
    public Midia getRowData(String rowKey) {
        List<Midia> midias = (List<Midia>) getWrappedData();

        for(Midia midia : midias) {
            if(midia.getCdMidia() == new Long(rowKey))
                return midia;
        }
        return null;
    }

    @Override
    public Object getRowKey(Midia midia) {
        return midia.getCdMidia();        
    }
}
