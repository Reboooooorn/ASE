import {IPerfume} from "../perfume/IPerfume";

export interface ICollection {
  id: number,
  name: string,
  perfumeResourceList: IPerfume[]
}
