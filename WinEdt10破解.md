#WinEdt10破解
1 打开winedt，到菜单options-->options interface...，这个选项包含了WinEdt的所有可配置的参数个功能，非常强大。单击子菜单项，已进行相关设置。 


2 刚才单击后，在WInEdt编辑区域左侧会弹出树形配置窗口，在第一层树形节点最下面找到advance configuration...-，单击展开。 


3 在展开后的子树分支中靠上面的地方找到event handlers子项，单击并展开。 


4 在刚展开的子树分支项中靠前面点找到Exit子项，并双击。 


5 然后可以看到右边弹出一个名为Exit.edt的配置文件，这个文件就是每次关闭WinEdt是，WinEdt会自行执行该文件中的语句。 


6 在配置文件Exit.edt最后一句“END;”前面一行加入 

RegDeleteValue('HKEY_CURRENT_USER', 'Software\WinEdt 10', 'Inst');
