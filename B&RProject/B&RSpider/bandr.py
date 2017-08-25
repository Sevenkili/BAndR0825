import requests
from bs4 import BeautifulSoup
import bs4
import re

urls=["https://www.yidaiyilu.gov.cn/info/iList.jsp?cat_id=10037&cur_page={}".format(str(i)) for i in range(1,4,1)]
headers={
    'Accept':'*/*',
    'Accept-Encoding':'gzip, deflate, br',
    'Accept-Language':'zh-CN,zh;q=0.8',
    'Connection':'keep-alive',
    'Cookie':'Hm_lvt_25e78b3fa4b036e241d0874f836fb377=1503411799; Hm_lpvt_25e78b3fa4b036e241d0874f836fb377=1503411799; JSESSIONID=965B4767DF8297529E2376C69BAB183A;BEC=325C64EB77487D8BFCEF595BA9999B26|WZw+r|WZw+V',
    'Host':'www.yidaiyilu.gov.cn',
    'Referer':'https://www.yidaiyilu.gov.cn/info/iList.jsp?tm_id=126&cat_id=10037&info_id=11111',
    'User-Agent':'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36',
    'Content-type':'text/html',
         }

def getCountryList(url, data= None):
    r=requests.get(url,headers=headers)
    soup=BeautifulSoup(r.text,'html.parser')
    countryName = soup.select('ul.commonList_dot > li > a')

    for country in zip(countryName):
        data = {
            'countryName': country[0].get('title'),
            'countryUrl': 'https://www.yidaiyilu.gov.cn'+country[0].get('href')
        }
        print(data)
        getContentOfUrl(data['countryUrl'],data['countryName'])



def getContentOfUrl(countryUrl,countryName):
    r = requests.get(countryUrl, headers=headers)
    r.encoding = "utf-8"
    soup = BeautifulSoup(r.text, 'html.parser')
    countryText = soup.select('div.info_content > p')
    str = ''
    for p in countryText:
        #print(p.get_text())
        if p.get_text != '\r\n' and p.get_text != '\n' and p.get_text != '':
            str += p.get_text()+'\n'
    writeTxt(countryName, str)

def writeTxt(countryName, str):
    file = open('/Users/qichenglin/Documents/项目/R&BProject/countrytxt/{}.txt'.format(countryName), 'w')
    if str != '':
        file.write(str.strip())
    file.close()

data = []
for url in urls:
    getCountryList(url,data)
