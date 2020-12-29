package no.bibsys.overdueNotices;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.ApiDescription;
import com.wordnik.swagger.model.Operation;
import com.wordnik.swagger.model.Parameter;

public class HiddenParamFilter implements SwaggerSpecFilter {

    @Override
    public boolean isOperationAllowed(Operation oprtn, ApiDescription ad, Map<String, List<String>> map, Map<String, String> map1, Map<String, List<String>> map2) {
        return true;
    }

    @Override
    public boolean isParamAllowed(Parameter prmtr, Operation oprtn, ApiDescription ad, Map<String, List<String>> map, Map<String, String> map1, Map<String, List<String>> map2) {

        if(prmtr.paramAccess().contains("hidden")) {
            return false;
        }
        return true;
    }
}
