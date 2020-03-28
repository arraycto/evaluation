local cache = ngx.shared.vtimes;
-- ��ȡ��ǰ������
local hosts = cjson.decode(cache:get("cluster"));
-- ��ȡ��ǰ�������±�
local currentserver = cache:get("currentserver")
-- ��ȡhosts��С
local size = table.getn(hosts["host"])
-- ��ȡ��ǰ�������б�
local serverList = hosts["host"]

-- ֻ��һ̨������
if (size == 1) then
    -- ���õ�ǰת����ַ
    balancer.set_current_peer(serverList[1]["host"], serverList[1]["port"])
else
    -- ��̨��ʼ��ѯ
    if (size < currentserver) then
        -- ������ǰ�����б� ��Ϊ��һ��
        currentserver = 1
    end
    balancer.set_current_peer(serverList[currentserver]["host"], serverList[currentserver]["port"])
    -- ��һ̨������
    cache:set("currentserver", currentserver + 1)
end
