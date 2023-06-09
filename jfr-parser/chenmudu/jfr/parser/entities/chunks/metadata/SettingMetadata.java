package jfr.parser.entities.chunks.metadata;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import jfr.parser.constans.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


/**
 * chenmudu@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingMetadata extends BaseTreeNodeElement {

    /**
     * key: value
     */
    private Map<String, String> settingMetadata;

    @Override
    public BaseTreeNodeElement getChildNodeElementByNodeName(String nodeName) {
        return null;
    }

    @Override
    public BaseTreeNodeElement buildCurrentNodeElementBaseProperties(String propertyKey, String propertyValue) {
        if (StrUtil.isNotEmpty(propertyKey) && StrUtil.equals(StringConstants.METADATA_TREE_NODE_PROPERTY_VALUE, propertyKey)) {
            if (CollectionUtil.isEmpty(this.settingMetadata)) {
                this.settingMetadata = new HashMap<>(10);
            }
            this.settingMetadata.put(propertyKey, propertyValue);
            return this;
        }
        return null;
    }
}
