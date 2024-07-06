import {RouterName} from "./routerName";

export const enum labelName{
    Home="首页",
    SongList = "歌单",
    Singer = "歌手",
    user = "用户"
}


export const  labelPath = [
    {
        name: labelName.Home,
        path: RouterName.Home
    },
    {
        name: labelName.SongList,
        path: RouterName.SongList
    },
    {
        name: labelName.Singer,
        path: RouterName.Singer
    },
]