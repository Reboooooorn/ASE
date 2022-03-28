import {IPerfume} from "../perfume/IPerfume";

export interface IWishlist {
  id: number,
  name: string,
  perfumeResourceList: IPerfume[]
}
