-- ����json
cjson = require "cjson"
-- ���븺�ؾ���
balancer = require "ngx.balancer"
--[[
Shared memory zones are always shared by all the Nginx worker processes in the current Nginx server instance.
-- ��cache�̰߳�ȫ����
-- DICTΪlua_shared_dictָ���Ĺ���洢����ȡ����shm��Lua�ֵ����
-- �����ڴ�����ʼ���ɵ�ǰNginx������ʵ���е�����Nginx�������̹���
--]]
cache = ngx.shared.vtimes

-- Ĭ������ ת���� 127.0.0.1:8081
local s1 = {}
local cluster = {}
s1["host"] = "127.0.0.1"
s1["port"] = "8081"
cluster["host"] = {}
cluster["host"][1] = s1
-- times Ϊ-1ʱ��ȡ������������
cache:set("times", -1)
-- ת��ΪJSON �����ڻ�����
cache:set("cluster", cjson.encode(cluster))
cache:set("currentserver", 1)
