import {IManufacturer} from "../manufacturer/IManufacturer";
import {INote} from "../note/INote";

export interface IPerfume {
  id: number,
  name: string,
  yearOfManufacture: number,
  manufacturer: IManufacturer,
  sizeInMilliliter: number,
  basicNote: INote,
  heartNote: INote,
  headNote: INote,
  collectionName: string
}
